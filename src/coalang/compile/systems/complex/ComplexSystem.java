package coalang.compile.systems.complex;

import java.util.ArrayList;
import java.util.List;

import io.github.coalangsoft.lang.context.CompileContext;
import io.github.coalangsoft.lang.context.CompileSystem;
import io.github.coalangsoft.lang.tree.Tree;
import io.github.coalangsoft.lang.tree.TreeItem;
import io.github.coalangsoft.lang.tree.TreeItemType;
import io.github.coalangsoft.lang.visit.StandardVisitor;

public abstract class ComplexSystem implements CompileSystem{

	@Override
	public abstract boolean accept(CompileContext context, TreeItem item);

	@Override
	public String compile(CompileContext context, TreeItem item) {
		List<TreeItem> it = new ArrayList<TreeItem>();
		for(int i = 1; i < item.at(0).length()-1; i++){
			it.add(item.at(0).at(i));
		}
		
		String s = Tree.createTree(it, TreeItemType.ROOT).visit(context, new StandardVisitor()).trim();
		
		return handleResult(context,s);
	}

	public abstract String handleResult(CompileContext context, String s);

}
