import java.util.ArrayList;
public class Token {
	private final String text;

	public String getValue() {
		return value;
	}

	private final String value;

	public String getChildrenTokensString() {
		return childrenTokensString;
	}

	private final String childrenTokensString;
	private final String type;

	public ArrayList<Token> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Token> children) {
		this.children = children;
	}

	private ArrayList<Token> children;

	public Token(String type, String text, String value, String childrenTokensString) {
		super();
		this.type = type;
		this.text = text;
		this.value = value;
		this.childrenTokensString = childrenTokensString;
	}

	public Token(String type, String text) {
		this(type, text, text, null);
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}
}