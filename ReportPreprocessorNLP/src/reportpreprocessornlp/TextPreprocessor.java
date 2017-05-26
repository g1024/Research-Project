/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportpreprocessornlp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mahmed27
 */
public class TextPreprocessor {
    
    private int dllfile;
    private int exefile;
    private int registrykey;
    private int servicekey;
    private int runkey;
    private int cve;
    private int url;
    private int ip;
    private int filePath;
    
    public TextPreprocessor() {
        this.dllfile = this.exefile = this.registrykey = this.servicekey = this.runkey 
                = this.cve = this.url = this.ip = this.filePath = 0;
    }
    
    public String preProcessText(File file, int buttonNo) throws FileNotFoundException {
        String text = new Scanner(file).useDelimiter("\\Z").next();
        if(buttonNo == 1) {
            text = replacePathWithRegex(text);
        } else {
            this.calculateIOCStatistics(text);
            System.out.println("this.dllfile = " + this.dllfile + " this.exefile" + this.exefile 
                    + " this.registrykey" + this.registrykey + " this.servicekey" + this.servicekey 
                    + " this.runkey" + this.runkey + " this.cve" + this.cve + " this.url" + this.url 
                    + " this.ip" + this.ip + " this.filePath" + this.filePath );
        }
        return text;
    }
    
    private String addDotAtEndOfLine(String text) {
        Pattern p = null;
        String out = "";
        
        p = Pattern.compile(Regex.endOfLine);
        Matcher m = p.matcher(text);
        while(m.find()) {
            String tmp = m.group().trim();
            if(tmp.isEmpty()) {
                continue;
            }
            tmp = tmp.replaceAll(":", "");
            out +=  tmp+ ".\n";
        }
        return out;
    }
    
    private String replacePathWithRegex(String text) {
        Pattern p = null;
        String out = null;
        
        p = Pattern.compile(Regex.runKey);
        out = p.matcher(text).replaceAll(Regex.runKeyRText);
        
        p = Pattern.compile(Regex.service);
        out = p.matcher(out).replaceAll(Regex.serviceRText);
        
        p = Pattern.compile(Regex.registryKeyPath);
        out = p.matcher(out).replaceAll("Add registry entries");
        
        p = Pattern.compile(Regex.dllFile);
        out = p.matcher(out).replaceAll(Regex.dllFileRText);
        
        p = Pattern.compile(Regex.executableFile);
        out = p.matcher(out).replaceAll(Regex.executableFileRText);
        
        p = Pattern.compile(Regex.filePath);
        out = p.matcher(out).replaceAll("Create files");
        
        p = Pattern.compile(Regex.registryKeyPath);
        out = p.matcher(out).replaceAll("Add registry entries");
        
        p = Pattern.compile(Regex.url);
        out = p.matcher(out).replaceAll("URL");
        
        p = Pattern.compile(Regex.urlWithwww);
        out = p.matcher(out).replaceAll("URL");
        
        p = Pattern.compile(Regex.urlWithoutwww);
        out = p.matcher(out).replaceAll("website");
        
        p = Pattern.compile(Regex.IP);
        out = p.matcher(out).replaceAll("IP");
        
//        p = Pattern.compile(this.endOfLine);
//        out = p.matcher(out).replaceAll(".");
        out = this.addDotAtEndOfLine(out);
        
        
        return out;
    }
    
    public void calculateIOCStatistics(String text) {
        if(Pattern.matches(Regex.IP, text)) {
            this.ip++;
        }
        if(Pattern.matches(Regex.dllFile, text)) {
            this.dllfile++;
        }
        if(Pattern.matches(Regex.executableFile, text)) {
            this.exefile++;
        }
        if(Pattern.matches(Regex.runKey, text)) {
            this.runkey++;
        }
        if(Pattern.matches(Regex.service, text)) {
            this.servicekey++;
        }
        if(Pattern.matches(Regex.registryKeyPath, text)) {
            this.registrykey++;
        }
        if(Pattern.matches(Regex.filePath, text)) {
            this.filePath++;
        }
        if(Pattern.matches(Regex.cve, text)) {
            this.cve++;
        }
        if(Pattern.matches(Regex.url, text) || Pattern.matches(Regex.urlWithoutwww, text)
                || Pattern.matches(Regex.urlWithwww, text)) {
            this.url++;
        }
    }
    
}
