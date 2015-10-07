/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * @author Stagiaire
 *
 */
@ManagedBean(name="imagesViewBean")
public class ImagesViewBean {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("bank" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
