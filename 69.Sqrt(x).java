    
//牛顿迭代
    long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return (int) r;

    My understanding of Newton's method:

Given y = f(x), find the root x such that f(x) = 0, geometrically
speaking, find the intersection of the function y and the x-axis.

For a roughly estimated root x0, it's coordinate on the function
is P(x0, f(x0)). We can find P's tangent line L whose slope is m,
such that the intersection of the L and the x-axis, say S(x1, 0),
it's function value f(x1) is closer to the real root of y = f(x),
comparing to the f(x0).

Set m = f'(x0), where f' denotes the differential on x0 ... (1)
The slope m is defined by PS: m = (f(x0) - 0) / (x0 - x1) ... (2)
Combine (1) (2), f'(x0) = f(x0) / (x0 - x1)
=> x0 - x1 = f(x0) / f'(x0)
=> x1 = x0 - f(x0) / f'(x0)

x(n+1) = x(n) - f(x(n)) / f'(x(n))
By applying Newton's method to the root problem, finding the
r such that r^2 equals to the input x is the same as finding the
root of f(r) where

f(r) = r^2 - x = 0
=> r(n+1) = r(n) - f(r(n)) / f'(r(n))
=> r(n+1) = r(n) - (r(n)^2 - x) / 2 * r(n)
=> r(n+1) = r(n) - r(n) / 2 + x / 2 * r(n)
=> r(n+1) = (r(n) + x / r(n)) / 2

The pseudo recursive code:

while ( r^2 - x > 0) {
    r = ( r + x / r ) / 2
}

https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation



The three solutions are as the follows, solution1 and solution3 are pretty straight forward.

 Look for the critical point: i * i <= x && (i+1)(i+1) > x
A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.

Solution1 - Binary Search Solution: Time complexity = O(lg(x)) = O(32)=O(1)

public int mySqrt(int x) {
	if (x == 0) return 0;
	int start = 1, end = x;
	while (start < end) { 
		int mid = start + (end - start) / 2;
		if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
			return mid; 
		else if (mid > x / mid)// Keep checking the left part
			end = mid;
		else
			start = mid + 1;// Keep checking the right part
	}
	return start;
}
Solution2 - Newton Solution: Time complexity = O(lg(x))

I think Newton solution will not be faster than Solution1(Binary Search), because i = (i + x / i) / 2, the two factors i and x / i are with opposite trends. So time complexity in the best case is O(lgx).

Anyone can give the accurate time complexity? Appreciate it!

public int mySqrt(int x) {
    if (x == 0) return 0;
	long i = x;
	while(i > x / i)  
		i = (i + x / i) / 2;	    	
	return (int)i;
}
Solution3 - Brute Force: Time complexity = O(sqrt(x))

public int mySqrt(int x) { 
	if (x == 0) return 0;
	for (int i = 1; i <= x / i; i++) 		
		if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
			return i;		
	return -1;
}