package model;

public class ToDoBean {
	private int id;
	private String title;
	private String priority;
	private String date;
	private String contents;
	private String done;

	public ToDoBean(int id, String title, String priority, String date, String contents, String done) {
		this.id = id;
		this.title = title;
		this.priority = priority;
		this.date = date;
		this.contents = contents;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPriority() {
		return priority;
	}

	public String getDate() {
		return date;
	}

	public String getContents() {
		return contents;
	}
	
	public String getDone() {
		return done;
	}
}
