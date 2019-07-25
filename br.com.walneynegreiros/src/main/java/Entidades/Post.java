package Entidades;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "postFacebook")
public class Post implements Serializable {
	@Id
	private Long id;
	private Date data;
	private String title;
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
