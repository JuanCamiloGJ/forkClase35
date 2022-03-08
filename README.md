# forkClase35
practica-adicional-clase35 
Tomando como base la clase 35 y el ejercicio de parseo de xlsx. 
1-  En el archivo articulos.xlsx que usamos en clases agregar una segundo hoja, replicar los estructura de filas y columnas de la primer hoja (cambiando valores!)
1.1 - modificar el código existente en XLSXFileParser .java para poder leer dicha hoja y agregar  los datos a la lista de artículos.
2 - Investigar una librería (ustedes deciden cual usar) que les permita generar un pdf a partir de los datos parseados del archivo archivos.xls.
El programa debe poder guardar dicho archivo pdf generado.
Corroborar que efectivamente contengo los datos.


en el paquete ar.com.educacionit.generic se creo una clase PDFCreator.

en la clase XLSXFileParser se modifico la linea 69 para no almacenar objetos null

en src/test/java se reutilizo la clase TestXLSXParser para utilizar el creador de pdfs lineas 20 - 22

el pdf que se crea se crea dentro del paquete src al lado del pom de app-web recargar vista si no lo ves.
