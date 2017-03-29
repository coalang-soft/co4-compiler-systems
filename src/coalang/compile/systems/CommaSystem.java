package coalang.compile.systems;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class CommaSystem implements CompileSystem {

	public static final String MARK = "comma";
	
	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		return item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.COMMA;
	}

	@Override
	public String compile(CompileContext context, TreeItem item) {
		StringBuilder b = new StringBuilder();
		if(context.hasHint(MARK)){
			b.append("invoke 1");
		}
		context.sendHint(MARK);
		if(b.length() != 0){
			b.append("\n");
		}
		b.append("get push");
		return b.toString();
	}

}
