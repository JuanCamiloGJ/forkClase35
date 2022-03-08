package ar.com.educacionit.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;

import ar.com.educacionit.domain.Articulos;

public class PDFCreator {
	
	Collection <Articulos> articulos = new ArrayList();
	
	public PDFCreator(Collection<Articulos> articulos) {
		// TODO Auto-generated constructor stub
		this.articulos = articulos;
	}
	public PDFCreator() {
		// TODO Auto-generated constructor stub
	}
	public Collection<Articulos> getArticulos() {
		return articulos;
	}
	public void setArticulos(Collection<Articulos> articulos) {
		this.articulos = articulos;
	}
	
	public void crearPDF(){
		if(!articulos.isEmpty()) {
			try(PDDocument document = new PDDocument()){
				//Establece el tamaño de la hoja
				PDPage page = new PDPage(PDRectangle.A2);
				
				//agregamos al documento una hoja
				document.addPage(page);
				
				//este obj nos permitirá configurar nuestra pagina y su contenido
				PDPageContentStream contentStream = new PDPageContentStream(document, page);
				
				//configurando el texto
				
				contentStream.beginText();
				contentStream.setFont(PDType1Font.COURIER, 14);
				contentStream.newLineAtOffset(50f, page.getMediaBox().getHeight() - 40f);
				String mostrar="CODIGO      NOMBRE      PRECIO      STOCK      CATEGORIA ID      MARCA ID      ";
				contentStream.setLeading(20f);//es el espacio entre lineas para usar newLine();
				contentStream.showText(mostrar);
				contentStream.newLine();
				
				for(Articulos aux : articulos) {
					
					mostrar = aux.getCodigo() + "      " +aux.getTitulo()	+ "       " +aux.getPrecio()
					+ "      " + aux.getStock() + "           " + aux.getCategoriaId()+ "                  " + aux.getMarcaId();				
					
					contentStream.showText(mostrar);
					contentStream.newLine();
				}
				contentStream.endText();
				contentStream.close();
				
				document.save("prueba_crear.pdf");
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}else {
			System.err.println("La coleccion de datos esta vacia, carga los datos mediante setArticulos();");
		}
	}
	
}
