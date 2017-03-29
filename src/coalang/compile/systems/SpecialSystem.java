package coalang.compile.systems;

import java.util.HashMap;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class SpecialSystem implements CompileSystem {

	private HashMap<String,String> map;
	public static final String MARKER = "special";
	
	public SpecialSystem(){
		this.map = new HashMap<String,String>();
	}
	
	public void add(String in, String out){
		map.put(in, out);
	}
	
	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.SPECIAL;
	}

	@Override
	public String compile(CompileContext context, TreeItem item) {
		String val = item.at(0).getTokens().at(0).getValue();
		String handler = map.get(val);
		
		if(handler == null){
			throw new RuntimeException("No special handler found: " + val);
		}
		context.sendHint(MARKER);
		return handler;
	}

}
