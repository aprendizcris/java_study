import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title = "";
	private String content = "";
	private int likes = 0;
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}

	public Post(Date moment, String title, String content) {
		this.moment = moment;
		this.title = title;
		this.content = content;
	}
	
	public void addLikes() {
		this.likes++;
	}

	public int getLikes() {
		return likes;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public List<Comment> getComments() {
		return this.comments;
	}

	public Date getMoment() {
		return moment;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( getTitle() + "\n");
		sb.append( getLikes() );
		sb.append( " like(s) - " + sdf.format( getMoment() ) + "\n");
		sb.append( getContent() + "\n");
		sb.append( "Comments:\n");

		for ( Comment c : getComments() ) {
			sb.append( c.getText() + "\n");
		}
		
		return sb.toString();
	}
}
