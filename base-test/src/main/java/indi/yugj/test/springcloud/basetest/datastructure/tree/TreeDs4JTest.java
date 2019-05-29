package indi.yugj.test.springcloud.basetest.datastructure.tree;

import net.sf.treeds4j.node.Node;
import net.sf.treeds4j.tree.InMemoryTree;
import net.sf.treeds4j.tree.bean.InMemoryTreeBean;
import net.sf.treeds4j.tree.bean.TreeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yugj
 * @date 2019/5/29 上午11:48.
 */
public class TreeDs4JTest {

    public void loadChildren() {

        CatNode catNode1 = new CatNode();
        catNode1.setName("root");
        catNode1.setParentId(0);
        catNode1.setId(1);

        CatNode catNode2 = new CatNode();
        catNode2.setName("ch 1");
        catNode2.setParentId(1);
        catNode2.setId(2);

        Node node = new Node(catNode1);
        Node node2 = new Node(catNode2);

        node2.setParent(node);

        List nodes = new ArrayList();
        nodes.add(node);
        nodes.add(node2);

        MemNode memNode = new MemNode(nodes);


    }

    class MemNode extends InMemoryTree {

        public MemNode(List originalList) {
            super(originalList);
        }

        @Override
        public boolean loadChildrenComparison(InMemoryTreeBean element, Node parentKey) {
            return false;
        }

        @Override
        public Node loadTree(TreeBean element) {
            return null;
        }
    }

    class CatNode {

        private Integer parentId;
        private String name;
        private Integer id;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
