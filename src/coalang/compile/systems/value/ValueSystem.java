package coalang.compile.systems.value;

import coalang.compile.systems.SpecialSystem;
import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lib.data.Pair;

public abstract class ValueSystem implements CompileSystem{

	@Override
	public abstract boolean accept(CompileContext context, TreeItem item);

	@Override
	public String compile(CompileContext context, TreeItem item) {
		Pair<String,Boolean> p = handle(context, item.at(0).getTokens().at(0).getValue());
		if(p.getB()){
			return p.getA();
		}
		StringBuilder b = new StringBuilder();
		b.append(p.getA());
		if(context.hasHint(SpecialSystem.MARKER)){
			b.append("\ninvoke 1");
		}
		return b.toString();
	}
	
	public abstract Pair<String, Boolean> handle(CompileContext context, String val);

}
