/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package de.tudresden.inf.st.most.jastadd.ast;
/**
 * @ast node
 * @declaredat /media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/expressions.ast:1
 * @production Root : {@link ASTNode} ::= <span class="component">{@link Def}*</span> <span class="component">{@link Exp}</span>;

 */
public class Root extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Root() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[2];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Root(List<Def> p0, Exp p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:25
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Root_unusedDefs_computed = null;
    Root_unusedDefs_value = null;
    contributorMap_Root_unusedDefs = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public Root clone() throws CloneNotSupportedException {
    Root node = (Root) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public Root copy() {
    try {
      Root node = (Root) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:64
   */
  @Deprecated
  public Root fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public Root treeCopyNoTransform() {
    Root tree = (Root) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public Root treeCopy() {
    Root tree = (Root) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:108
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Def list.
   * @param list The new list node to be used as the Def list.
   * @apilevel high-level
   */
  public void setDefList(List<Def> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Def list.
   * @return Number of children in the Def list.
   * @apilevel high-level
   */
  public int getNumDef() {
    return getDefList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Def list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Def list.
   * @apilevel low-level
   */
  public int getNumDefNoTransform() {
    return getDefListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Def list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Def list.
   * @apilevel high-level
   */
  public Def getDef(int i) {
    return (Def) getDefList().getChild(i);
  }
  /**
   * Check whether the Def list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDef() {
    return getDefList().getNumChild() != 0;
  }
  /**
   * Append an element to the Def list.
   * @param node The element to append to the Def list.
   * @apilevel high-level
   */
  public void addDef(Def node) {
    List<Def> list = (parent == null) ? getDefListNoTransform() : getDefList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addDefNoTransform(Def node) {
    List<Def> list = getDefListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Def list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDef(Def node, int i) {
    List<Def> list = getDefList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Def list.
   * @return The node representing the Def list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Def")
  public List<Def> getDefList() {
    List<Def> list = (List<Def>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Def list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Def list.
   * @apilevel low-level
   */
  public List<Def> getDefListNoTransform() {
    return (List<Def>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Def list without
   * triggering rewrites.
   */
  public Def getDefNoTransform(int i) {
    return (Def) getDefListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Def list.
   * @return The node representing the Def list.
   * @apilevel high-level
   */
  public List<Def> getDefs() {
    return getDefList();
  }
  /**
   * Retrieves the Def list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Def list.
   * @apilevel low-level
   */
  public List<Def> getDefsNoTransform() {
    return getDefListNoTransform();
  }
  /**
   * Replaces the Exp child.
   * @param node The new node to replace the Exp child.
   * @apilevel high-level
   */
  public void setExp(Exp node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Exp child.
   * @return The current node used as the Exp child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Exp")
  public Exp getExp() {
    return (Exp) getChild(1);
  }
  /**
   * Retrieves the Exp child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Exp child.
   * @apilevel low-level
   */
  public Exp getExpNoTransform() {
    return (Exp) getChildNoTransform(1);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/Analysis.jrag:3
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Root_unusedDefs = null;

  protected void survey_Root_unusedDefs() {
    if (contributorMap_Root_unusedDefs == null) {
      contributorMap_Root_unusedDefs = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Root_unusedDefs(this, contributorMap_Root_unusedDefs);
    }
  }

  /**
   * @attribute syn
   * @aspect Printing
   * @declaredat /media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/Printing.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Printing", declaredAt="/media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/Printing.jrag:3")
  public String print() {
    {
          String result = "";
          for (Def def : getDefList()) {
            result += def.print() + "\n";
          }
          result += getExp().print();
          return result;
        }
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
  /**
   * @attribute coll
   * @aspect Analysis
   * @declaredat /media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/Analysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Analysis", declaredAt="/media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/src/main/jastadd/Analysis.jrag:3")
  public java.util.Set<Def> unusedDefs() {
    ASTNode$State state = state();
    if (Root_unusedDefs_computed == ASTNode$State.NON_CYCLE || Root_unusedDefs_computed == state().cycle()) {
      return Root_unusedDefs_value;
    }
    Root_unusedDefs_value = unusedDefs_compute();
    if (state().inCircle()) {
      Root_unusedDefs_computed = state().cycle();
    
    } else {
      Root_unusedDefs_computed = ASTNode$State.NON_CYCLE;
    
    }
    return Root_unusedDefs_value;
  }
  /** @apilevel internal */
  private java.util.Set<Def> unusedDefs_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Root)) {
      node = node.getParent();
    }
    Root root = (Root) node;
    root.survey_Root_unusedDefs();
    java.util.Set<Def> _computedValue = new java.util.HashSet<Def>();
    if (root.contributorMap_Root_unusedDefs.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Root_unusedDefs.get(this)) {
        contributor.contributeTo_Root_unusedDefs(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected ASTNode$State.Cycle Root_unusedDefs_computed = null;

  /** @apilevel internal */
  protected java.util.Set<Def> Root_unusedDefs_value;

}
