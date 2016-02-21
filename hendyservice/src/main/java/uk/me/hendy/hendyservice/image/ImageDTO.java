package uk.me.hendy.hendyservice.image;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import uk.me.hendy.hendyservice.menu.MenuItemDTO;

/**
 * An Image is a holder for a Hendy image.
 * @author Dave
 *
 */
@XmlRootElement(name="Image")
public class ImageDTO {

	Date dateCreated;
	String name;
	String path;
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Image [name=" + name + ", " +
				     "path=" + path	+ ", +" +
				     "dateCreated=" + dateCreated + "]";
	}

}
