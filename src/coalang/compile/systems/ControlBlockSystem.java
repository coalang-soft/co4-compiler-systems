package coalang.compile.systems;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.token.TokenType;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;
import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.Pair;

public class ControlBlockSystem implements CompileSystem{

	public boolean accept(CompileContext context, TreeItem item, boolean asValue) {
		if(item.length() != 3){
			return false;
		}
		if(item.at(0).getType() != TreeItemType.TOKEN){
			return false;
		}
		if(item.at(0).getTokens().get(0).getType() == TokenType.NAME);
		return item.getChildTypes().matcher(
			TreeItemType.TOKEN,
			TreeItemType.GROUP,
			TreeItemType.BLOCK
		).matches(new Func<Pair<TreeItemType,TreeItemType>, Boolean>() {
			public Boolean call(Pair<TreeItemType, TreeItemType> p) {
				return p.getA() == p.getB();
			}
		});
	}

	public String compile(CompileContext context, TreeItem item, boolean asValue) {
		item.makeException("NIy");
		return null;
	}

}
