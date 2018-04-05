------ Resum de tasques fetes ------

JORDI SOLÀ
-Main (Main.java)
-Menu (Menu.java)
-Estructura de totes les queries
-Tots els getters i setters
-delete arxius-consultes (Consultes.java)
-3 queries de préstecs (Prestecs.java)
-UsosInternet
-Visites
-1 Query (Usuaris.java)
-update, delete, insert (Usuaris.java)

ALEJANDRO BERDÚN
-GestorBD(GestorBD.java)
-insert arxius-consultes(Consultes.java)
-update arxius-consultes(Consultes.java)
-3 queries arxius-consultes(Consultes.java)
-1 query (Prestecs.java)
-update, delete, insert (Prestecs.java)
-3 queries (Usuaris.java)


------ Contingut de les sentències XQJ ------

ARXIU-CONSULTES
a) Consultes presencials (tots els equipaments) [Ordenades de manera descendent amb 'order by']
b) Consultes presencials (equipaments tipus Arxiu)
c) Consultes presencials (equipaments tipus Biblioteca)
d) Tota la informació
e) Inserció d'entrades
f) Eliminació d'entrades [inclou comprovació de si existeixen]
g) Modificació de consultes presencials [inclou comprovació de si existeixen]

BIBLIOTEQUES-PRESTECS
a) Tota la informació [Ordenada de manera descendent amb 'order by']
b) Equipaments amb més de 100 mil préstecs [condició amb 'where' i ordenació amb 'order by']
c) Suma total de préstecs al 2016 [suma amb 'sum' i casting amb 'xs:integer()']
d) Préstecs per districte [pseudo 'group by' (estil SQL) amb combinació de distinct-values(), for() i sum()]
e) Inserció d'entrades
f) Eliminació d'entrades [inclou comprovació de si existeixen]
g) Modificació de préstecs [inclou comprovació de si existeixen]

BIBLIOTEQUES-USOSINTERNET
-->Basat en l'estructura de 'biblioteques-prestecs'
a) Tota la informació
b) Equipaments amb més de 100 mil usos d'Internet
c) Suma total d'usos d'Internet al 2016
d) Usos d'Internet per districte
e) Inserció d'entrades
f) Eliminació d'entrades
g) Modificació d'usos d'Internet

ARXIU-USUARIS
a) Tota la informació
b) Usuaris per equipament
c) Suma total d'usuaris al 2016 [amb sum()]
d) Quantitat d'àmbits [amb count() i distinct-values()]
e) Inserció d'entrades
f) Eliminació d'entrades [inclou comprovació de si existeixen]
g) Modificació d'usuaris [inclou comprovació de si existeixen]

BIBLIOTEQUES-VISITES
-->Basat en l'estructura de 'biblioteques-prestecs'
a) Tota la informació
b) Equipaments amb més de 100 mil visites
c) Suma total de visites al 2016
d) Visites per districte
e) Inserció d'entrades
f) Eliminació d'entrades
g) Modificació de visites