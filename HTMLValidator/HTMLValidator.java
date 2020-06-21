import java.util.Queue;
import java.util.Stack;

public class HTMLValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> badTags = new Stack<>();
		HtmlTag el;
		//enhanced for loop because there's no index
				//push all open tags into badTags then pop those that have closing tag
				while(tags.size() > 0) {
					el = tags.poll();
					if (el.isOpenTag()) {
						badTags.push(el);
					} else {
						if (!el.isSelfClosing()) { //closing tag
							if (badTags.isEmpty()) { //all matched
								return null;		//null for file containing closing tag
							} 
							if (el.matches(badTags.peek())) {
								badTags.pop();
							} else {
								return badTags;
							}
						}
					}
				} 
				
				System.out.println("result: " + badTags);
		return badTags;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			System.out.println(HtmlReader.getTagsFromHtmlFile("test1").getClass());
			Queue queue = HtmlReader.getTagsFromHtmlFile("test1");//FIFO - add to the end, remove from front
			isValidHtml(queue);
		}catch(Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
		

	}

}
