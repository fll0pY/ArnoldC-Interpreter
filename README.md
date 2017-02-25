# ArnoldC-Interpreter
A simplified interpreter for the Arnold Schwarzenegger based programming language.

Pentru citirea din fisier, am scris un InputParser care imi returneaza urmatoarea
instructiune valida in fisier. Dupa aceea, pentru crearea arborelui, am tratat
separat MainBody, IfBody, ElseBody, si WhileBody pe care le-am creat recursiv.

Pentru crearea unui AssignmentNode, am parcurs liniar instructiunile din interiorul
lui si am parentat nodul de pe pozitia i la nodul de pe pozitia i+1, iar ultimul
nod la nodul parinte AssignmentNode.

Am o interfata Visitable, pe care o implementeaza toate nodurile si o
interfata Visitor pe care o implementeaza visitor-ul de afisare al arborelui si 
visitor-ul de interpretare.

Pentru afisare vizitez MainNode si de acolo visitez recursiv intr-un DFS, toate
celelalte noduri si folosesc un parametru level pentru a stii cate tab-uri sa
printez inainte de fiecare nod.

La interpretare vizitez mai intai MainNode si dupa aceea, recursiv celelalte noduri.
Nodurile care returneaza o valoare cum ar fi operatiile, nodurile constante si 
nodurile de tip variabila, mostenesc o clasa ValueNode ce contine un int value.
Acest value e setat cu valoarea buna in momentul visitarii.
