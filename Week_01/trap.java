import java.util.Stack;

class trap {
    public int trap(int[] height) {
        if(height == null) return 0;
        Stack<Integer> stack = new Stack();
        int cur = 0, ans = 0;
        while(cur < height.length){
            while(!stack.isEmpty()&& height[cur]>height[stack.peek()]){
                int top = stack.peek();
                stack.pop();
                if(stack.isEmpty()) break;
                int distance = cur-stack.peek()-1;
                int bound = Math.min(height[cur], height[stack.peek()]) - height[top];
                ans+=distance*bound;
            }
            stack.push(cur++);
        }
        return ans;

    }
}
