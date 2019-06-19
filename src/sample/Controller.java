package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextField url;
    public WebView webview;
    List<String> urls = new ArrayList<String>();
    List<String> urls1 = new ArrayList<String>();
    int counter = -1;
    int counter1 = 0;

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
        if(urls1.size()>0 && urls1.get(urls1.size()-1) != webview.getEngine().getLocation()){
            urls1.clear();
        }
    }
    public void btnBack(ActionEvent actionEvent){
        if (urls.size()<=1 || counter <=0){
            System.out.println("naklebi var");
        }
        else {
            if(urls1.size()>0){
                if (urls1.get(urls1.size()-1) != webview.getEngine().getLocation()){
                    urls1.add(webview.getEngine().getLocation());
                }
            }
            else {
                    urls1.add(urls.get(urls.size()-1));
            }
            urls.remove(urls.size()-1);
            counter-=1;
            counter1+=1;
            String oldUrl = urls.get(counter);
            try {
                WebEngine engine = webview.getEngine();
                engine.load(oldUrl);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void btnForward (ActionEvent actionEvent){
        if (urls1.size() < 1){
            System.out.println("naklebii");
        }
        else {
            if (urls.get(urls.size()-1) != webview.getEngine().getLocation()){
                urls.add(webview.getEngine().getLocation());
                counter+=1;
            }
            String fUrl=urls1.get(counter1 -= 1);
            urls1.remove(counter1);
            try {
                WebEngine engine = webview.getEngine();
                engine.load(fUrl);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void urladd(){
        System.out.println(urls1);
        if (urls.get(urls.size() - 1) != webview.getEngine().getLocation()){
            counter+=1;
            urls.add(webview.getEngine().getLocation());
        }
        if(urls1.size()>0 && urls1.get(urls1.size()-1) != webview.getEngine().getLocation()){
            urls1.clear();
        }
    }
    public void btnReload (ActionEvent actionEvent){
        try {
            WebEngine engine = webview.getEngine();
            engine.reload();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
