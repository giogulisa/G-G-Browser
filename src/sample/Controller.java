package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextField url;
    public WebView webview;
    List<String> urls = new ArrayList<String>();
    List<String> urls1 = new ArrayList<String>();
    int counter=-1;

    public void btnEnter(ActionEvent actionEvent){
        counter+=1;
        String current_Urll="http://www." + url.getText();
        try {
            urls.add(current_Urll);
            WebEngine engine = webview.getEngine();
            engine.load(current_Urll);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void btnBack(ActionEvent actionEvent){
        System.out.println("ბექი მოხდა");
        if (urls.size()<=1 || counter <=0){
            System.out.println("naklebi var");
        }
        else {
            System.out.println("counter and size");
            System.out.println(counter);
            System.out.println(urls.size());
            urls1.add(urls.get(urls.size()-1));
            urls.remove(urls.size()-1);
            counter-=1;
            String oldUrl = urls.get(counter);
            System.out.println(urls);
            System.out.println(urls.get(counter));
            try {
                WebEngine engine = webview.getEngine();
                engine.load(oldUrl);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void urladd(){
        System.out.println("clicked");
        System.out.println(webview.getEngine().getLocation());
        if (urls.get(urls.size() - 1) != webview.getEngine().getLocation()){
            counter+=1;
            urls.add(webview.getEngine().getLocation());
        }
    }
}
