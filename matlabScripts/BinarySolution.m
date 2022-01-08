%二分法求非线性方程根
%输入：
%   low:区间下界
%   upper:区间上界
%   TOL:误差容限
function BinarySolution(low,upper,TOL)
    a=low;b=upper;
    m=ceil(log((b-a)/TOL)/log(2)); 
    % m为最大迭代次数与区间长度和误差容限有关
    for k=1:m
        p=(a+b)/2;
        if myFunc(p)*myFunc(b)<0
            a=p;
        else
            b=p;
        end
    end
    disp(['经过二分法求得的根为：x=',num2str((a+b)/2,'%.6f')])
    disp(['共经过',num2str(k),'次计算'])
end

