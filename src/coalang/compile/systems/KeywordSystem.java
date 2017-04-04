package coalang.compile.systems;

import coalang.compile.systems.value.NameLoadSystem;
import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;

public class KeywordSystem implements CompileSystem{

	public static final CompileSystem VAR = new KeywordSystem("var", NameLoadSystem.class);
	
	private String name;
	private Class<? extends CompileSystem> next;

	public KeywordSystem(String name, Class<? extends CompileSystem> next){
		this.name = name;
		this.next = next;
	}
	
	@Override
	public boolean accept(CompileContext context, TreeItem item) {
		if(item.length() != 1){
			return false;
		}
		if(item.at(0).getTokens().getTypes().atOrDefault(0, null) == TokenType.NAME){
			return item.at(0).getTokens().at(0).getValue().equals(name);
		}
		return false;
	}

	@Override
	public String compile(CompileContext context, TreeItem item) {
		context.requireNext(next);
		return "";
	}

}
