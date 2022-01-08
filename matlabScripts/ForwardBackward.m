%输入：（以四阶矩阵为例）
%   L矩阵为  p1 0   0  0
%           a2  p2  0  0
%            0  a3 p3  0
%            0  0  a4  p4 
%   U矩阵为  1  q1  0  0
%            0  1  q2  0
%            0  0  1  q3
%            0  0  0   1 
%    b = （b1,b2,b3,b4）
%输出：L*Ux=b中的解向量x
function x=ForwardBackward(a,p,q,b)
n=length(b);%n为方程的维度
%步骤1：解下三角方程组Ly=b
y(1)=b(1)/p(1);
for i=2:n
    y(i)=(b(i)-a(i)*y(i-1))/p(i);
end

%步骤2：解上三角方程组Ux=y
x(n)=y(n);
for i=n-1:-1:1
    x(i)=y(i)-q(i)*x(i+1);
end
x=x';%转置向量
end