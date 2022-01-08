syms u(t) v(t) w(t) y(t) z(t) t;
eqn=[diff(u)==0.5*u*(w-u)/v,diff(v)==-0.5*(w-u),diff(w)==(0.9-1000*(w-y)-0.5*w*(w-u))/z,diff(y)==-100*(y-w),diff(z)==0.5*(w-u),u(0)==v(0)==w(0)==1,z(0)==-10,w(1)==y(1)];
S=dsolve(eqn,t);