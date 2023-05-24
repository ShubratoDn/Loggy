package loggy.entities;

import java.util.Date;

public class Post {
	
	private int id;
	private String title;
	private String content;
	private Date upload_date;
	
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Post(int id, String title, String content, Date upload_date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.upload_date = upload_date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", upload_date=" + upload_date + "]";
	}

	
	
	
	
}
