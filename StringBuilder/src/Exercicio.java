import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Exercicio {

	public static void main(String[] args) throws ParseException {
		List<Post> posts = new ArrayList<Post>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Post post = new Post( sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand", "I´m going to visit this wonderful country!" );
		post.addComment(new Comment("Have a nice trip"));
		post.addComment(new Comment("Wow that´s awesome!"));
		
		for (int i=0; i<12; i++)
			post.addLikes();
		posts.add(post);


		post = new Post( sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomorrow" );
		post.addComment(new Comment("Good night"));
		post.addComment(new Comment("May the Force be with you"));
		
		for (int i=0; i<5; i++)
			post.addLikes();
		posts.add(post);

		
		
		System.out.println("------------------");
		System.out.println("Post(s)...: " + posts.size() + "\n");
		
		for ( Post postI:posts ) {
			System.out.println( "Title: " + postI.getTitle() );
			System.out.println( "Content: " + postI.getContent() );
			System.out.println( "In: " + sdf.format( postI.getMoment() ) );
			System.out.println( "like(s): " + postI.getLikes() );
			System.out.println("--- Comments ---");
			
			for ( Comment comment:postI.getComments()) {
				System.out.println( "- " + comment.getText() );
			}
			
			System.out.println("----------------------\n");
		}

		System.out.println("----- toString() ----");
		for ( Post postI:posts ) {
			System.out.println( postI.toString() );
		}

		System.out.println("----------------------\n");
	}
}
