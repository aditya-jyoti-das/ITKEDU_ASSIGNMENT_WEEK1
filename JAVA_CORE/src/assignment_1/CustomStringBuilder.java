package assignment_1;


import java.util.Stack;

public class CustomStringBuilder {

    private StringBuilder stringBuilder;

    private Stack<String> undoStacks = new Stack<>();


    public CustomStringBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    public CustomStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public CustomStringBuilder(int capacity) {
        this.stringBuilder = new StringBuilder(capacity);
    }

    public CustomStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
    }

    public CustomStringBuilder(CharSequence seq) {
        this.stringBuilder = new StringBuilder(seq);
    }

    public int comparedTo(CustomStringBuilder another) {
        return this.stringBuilder.compareTo(another.stringBuilder);
    }

    public <T> CustomStringBuilder append(T in) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.append(in);
        return this;
    }

    public CustomStringBuilder appendCodePoint(int codePoint) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.appendCodePoint(codePoint);
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.delete(start, end);
        return this;
    }

    public CustomStringBuilder deleteCharAt(int index) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.deleteCharAt(index);
        return this;
    }

    public CustomStringBuilder replace(int start, int end, String str) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.replace(start, end, str);
        return this;
    }

    public CustomStringBuilder insert(int index, char[] str, int offset, int len) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.insert(index, str, offset, len);
        return this;
    }

    public CustomStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.insert(dstOffset, s, start, end);
        return this;
    }

    public <T> CustomStringBuilder insert(int offset, T b) {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.insert(offset, b);
        return this;
    }

    public int indexOf(String str) {
        return this.stringBuilder.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return this.stringBuilder.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return this.stringBuilder.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return this.stringBuilder.lastIndexOf(str, fromIndex);
    }

    public CustomStringBuilder reverse() {
        this.pushToHistoryStack(this.stringBuilder.toString());
        this.stringBuilder.reverse();
        return this;
    }

    public String toString() {
        return this.stringBuilder.toString();
    }

    // undo method implementation
    private void pushToHistoryStack(String str) {
        if(!this.undoStacks.isEmpty() && this.undoStacks.peek().equals(str)){
           return;
        }
        this.undoStacks.push(str);
    }

    public void undo() {
        if (this.undoStacks.isEmpty()) {
            return;
        }
        String pop = this.undoStacks.pop();
        this.stringBuilder.setLength(0);
        this.stringBuilder.append(pop);
    }

}
