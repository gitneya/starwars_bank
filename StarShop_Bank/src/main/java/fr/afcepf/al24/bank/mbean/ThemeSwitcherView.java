/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import fr.afcepf.al24.bank.theme.Theme;

/**
 * @author Stagiaire
 *
 */
@ManagedBean
@ApplicationScoped
public class ThemeSwitcherView {
 
	private Logger log = Logger.getLogger(ThemeSwitcherView.class);
    private List<Theme> themes;
    private String theme = "trontastic";
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
 
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
 
    public void setService(ThemeService service) {
        this.service = service;
    }
	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		log.info("ThemeSwitcherView.setTheme : nouveau Theme : " + theme );
		this.theme = theme;
	}
}