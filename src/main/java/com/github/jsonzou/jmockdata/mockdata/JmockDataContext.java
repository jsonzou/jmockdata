
package com.github.jsonzou.jmockdata.mockdata;

import com.github.jsonzou.jmockdata.utils.ReflectionUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>模拟数据上下文</p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public class JmockDataContext {
    private JmockDataContext root;
    private JmockDataContext parent;
    private List<JmockDataContext> children = new ArrayList<JmockDataContext>();
    private Integer level;
    private Integer selfRefLevel;
    private String name;
    private Class mockType;
    private Class selfRefType;
    private Type genericType = null;

    public static JmockDataContext newInstance(JmockDataContext parentContext, String name, Class mockType, Type genericType) {
        JmockDataContext context = new JmockDataContext();
        context.setLevel(parentContext.getLevel() + 1);
        context.setName(name);
        context.setMockType(mockType);
        context.setGenericType(genericType);
        context.setParent(parentContext);
        parentContext.getChildren().add(context);
        context.setRoot(parentContext.getRoot());
        context.computeSelfRefLevel();
        return context;
    }

    public static JmockDataContext newRootInstance(Class mockType) {
        JmockDataContext context = new JmockDataContext();
        context.setName("ROOT");
        context.setLevel(0);
        context.setSelfRefLevel(0);
        context.setSelfRefType(mockType);
        context.setMockType(mockType);
        context.setRoot(context);
        return context;
    }

    public void printTree() {
        printTree(this);
    }

    private void printTree(JmockDataContext ctx) {
        if(!JMockDataManager.getInstance().getConfig().getPrintContext()){
            return ;
        }
        if (ctx == null) {
            printTree(this.getRoot());
        } else if (ctx == ctx.getRoot()) {
            System.out.println(ctx.getName());
        }

        List<JmockDataContext> ch = ctx.getChildren();
        if (ch != null && ch.size() > 0) {
            for (JmockDataContext cx : ch) {
                printContex(cx);
                printTree(cx);
            }
        }


    }

    private void printContex(JmockDataContext cx) {
        int level = cx.getLevel();
        while (level-- > 0) {
            System.out.print("  ");
        }
        System.out.print("|");
        System.out.print("_");
        System.out.print(cx.getName() + "[level=" + cx.getLevel() + ",class=" + cx.mockType.getName() + "]");
        System.out.println();
    }

    public List<JmockDataContext> getChildren() {
        return children;
    }

    public void setChildren(List<JmockDataContext> children) {
        this.children = children;
    }

    public JmockDataContext getRoot() {
        return root;
    }

    public void setRoot(JmockDataContext root) {
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public JmockDataContext getParent() {
        return parent;
    }

    public void setParent(JmockDataContext parent) {
        this.parent = parent;
    }

    public Class getMockType() {
        return mockType;
    }

    public void setMockType(Class mockType) {
        this.mockType = mockType;
    }

    public Integer getSelfRefLevel() {
        return selfRefLevel;
    }

    public void setSelfRefLevel(Integer selfRefLevel) {
        this.selfRefLevel = selfRefLevel;
    }

    public Type getGenericType() {
        return genericType;
    }

    public void setGenericType(Type genericType) {
        this.genericType = genericType;
    }

    public Class getSelfRefType() {
        return selfRefType;
    }

    public void setSelfRefType(Class selfRefType) {
        this.selfRefType = selfRefType;
    }

    private void computeSelfRefLevel() {
        try {
            if (this.getParent().getMockType().equals(this.getMockType())
                    || this.getParent().getSelfRefType().equals(this.getMockType())) {
                this.setSelfRefLevel(this.getParent().getSelfRefLevel() + 1);
                this.setSelfRefType(this.getParent().getSelfRefType());
            } else if (
                    ReflectionUtil.isComponeClassContains(this.getMockType(), this.getGenericType(), this.getParent().getMockType())
                    || ReflectionUtil.isComponeClassContains(this.getMockType(), this.getGenericType(), this.getParent().getSelfRefType())) {
                this.setSelfRefLevel(this.getParent().getSelfRefLevel() + 1);
                this.setSelfRefType(this.getParent().getSelfRefType());
            }

            if (this.getSelfRefLevel() == null) {
                this.setSelfRefLevel(0);
            }
            if (this.getSelfRefType() == null) {
                this.setSelfRefType(this.getMockType());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
