package com.hh.export.service.writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Mohamed Riyas
 * 
 *         <p>
 *         The PDF creator class is used to create PDF documents in the
 *         application. It helps us to create documents, add pages, and have
 *         helper methods.
 *         </p>
 */
public class HHExportPdfCreatorService {

	private PDDocument document = null;
	private final PDFont fontTimesBold = PDType1Font.TIMES_BOLD;
	private final PDFont fontTimes = PDType1Font.TIMES_ROMAN;

	public HHExportPdfCreatorService() {
	}

	public PDPage addA4PageToPDF() {
		document = new PDDocument();
		PDPage page = new PDPage(PDRectangle.A4);
		document.addPage(page);
		return page;
	}

	public PDPageContentStream getContentStream(PDPage page) throws IOException {
		return new PDPageContentStream(document, page);
	}

	public void closePageContentStream(PDPageContentStream cos) throws IOException {
		cos.close();
	}

	public void saveAsPdf(OutputStream os) throws IOException {
		document.save(os);
		document.close();
	}

	public PDImageXObject getImageObject(InputStream input) throws IOException {
		return new PDImageXObject(new PDStream(document, input), new PDResources());
	}

	public void drawImage(PDPageContentStream cos, PDImageXObject ximage, float scale) throws IOException {
		cos.drawImage(ximage, this.getCurrentPosX(), this.getCurrentPosY(), ximage.getWidth() * scale,
				ximage.getHeight() * scale);
	}

	public float contentWidthByFontTB(String contentText, int contentFontSize) throws IOException {
		return fontTimesBold.getStringWidth(contentText) / 1000 * contentFontSize;
	}

	public float contentWidthByFontTimes(String contentText, int contentFontSize) throws IOException {
		return fontTimes.getStringWidth(contentText) / 1000 * contentFontSize;
	}

	public float contentHeightByFontTB(int contentFontSize) {
		return fontTimesBold.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * contentFontSize;
	}

	public float findMiddleX(PDPage page, float contentWidth) {
		return (page.getMediaBox().getWidth() - contentWidth) / 2;
	}

	public float findStartY(PDPage page, float contentWidOrHeight, float customLen) {
		return (page.getMediaBox().getHeight() - contentWidOrHeight - customLen);
	}

	public void createUnderline(PDPageContentStream cos, float width) throws IOException {
		cos.setLineWidth(1);
		cos.addLine(this.getCurrentPosX(), this.getCurrentPosY(), width, this.getCurrentPosY());
		cos.closeAndStroke();
	}

	public void createHeaderTextByTB(PDPageContentStream cos, Color color, String headerText, int fontSize)
			throws IOException {
		// Define a text content stream
		cos.beginText();
		// Selecting the font
		cos.setFont(fontTimesBold, fontSize);
		cos.setNonStrokingColor(color);
		// moving the cursor
		cos.newLineAtOffset(this.getCurrentPosX(), this.getCurrentPosY());
		// drawing the text
		cos.showText(headerText);
		// end the text editing
		cos.endText();
	}

	public void createContentTextByTimes(PDPageContentStream cos, Color color, String contentText, int fontSize)
			throws IOException {
		cos.beginText();
		cos.setFont(fontTimes, fontSize);
		cos.setNonStrokingColor(color);
		cos.newLineAtOffset(this.getCurrentPosX(), this.getCurrentPosY());
		cos.showText(contentText);
		cos.endText();
	}

	public float getCurrentPosX() {
		return CURRENTPOS.COORDINATE_XY.getStartX();
	}

	public float getCurrentPosY() {
		return CURRENTPOS.COORDINATE_XY.getStartY();
	}

	public CURRENTPOS getCurrentPos() {
		return CURRENTPOS.COORDINATE_XY;
	}

	public void setCurrentPos(float startX, float startY) {
		CURRENTPOS.COORDINATE_XY.setStartX(startX);
		CURRENTPOS.COORDINATE_XY.setStartY(startY);
	}

	private enum CURRENTPOS {
		COORDINATE_XY;

		private float startX;
		private float startY;

		CURRENTPOS() {
		}

		public float getStartX() {
			return this.startX;
		}

		public void setStartX(float startX) {
			this.startX = startX;
		}

		public float getStartY() {
			return this.startY;
		}

		public void setStartY(float startY) {
			this.startY = startY;
		}
	}

}
