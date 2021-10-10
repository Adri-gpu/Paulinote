package fichiersreu;

//@author M0riz

import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;
import src.main.*;


public class ListePdf {
    //Listes des différentes polices
    private static final Font YFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.NORMAL, new BaseColor(250,200,70));
    private static final Font BFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.NORMAL, new BaseColor(25,210,225));
    private static final Font Foot = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.NORMAL);
    private static final Font FootBold = new Font(Font.FontFamily.TIMES_ROMAN, 8,
            Font.BOLD);
    private static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 11);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.BOLD);
    private static final Font Small = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    private static final Font Bold_Underline = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.BOLD|Font.UNDERLINE);
    private static final Font Underline = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.UNDERLINE);
    private static final Font Adress = new Font(Font.FontFamily.TIMES_ROMAN, 9,
            Font.BOLD);
    private static final Font Bon = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    private static final Font SignatureBon = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.ITALIC);

    protected static void PageConvoc(String nom_reu,String ordre,String date, String horaire, String lieu) 
            throws DocumentException, IOException {
        try{
            Bdd bdd = new Bdd();
            ArrayList<Utilisateur> List_User = bdd.getIdentUser();
            
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(Main.PathApp+ 
                    "\\Pdf\\Convocation_"+nom_reu+".pdf"));
            document.open();
            document.addTitle("Convocation_"+nom_reu);
            document.addAuthor(Utilisateur.getPrenom()+ " "+Utilisateur.getNom());
            Paragraph preface = new Paragraph();
            Image img = Image.getInstance(Main.PathApp+"\\Logo_IUT.png");
            preface.add(new Image(img) {});
            preface.add(new Paragraph("Département Informatique, site d'Arles", YFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Sécrétariat pédagogique Dpt Informatique", Adress));
            document.add(preface);

            preface = new Paragraph();
            preface.add(new Chunk("Affaire suivie par :" + System.lineSeparator(),Adress));   
            preface.add(new Chunk(List_User.get(0).getPrenom()+ " "+List_User.get(0).getNom()
                    + System.lineSeparator(),Adress));  
            preface.add(new Chunk(List_User.get(0).getMail(),Adress));  
            preface.setAlignment(Element.ALIGN_RIGHT);
            preface.setIndentationRight(360);
            document.add(preface);

            Paragraph invite = new Paragraph();
            invite.add(new Chunk("A l'attention des membres du Conseil de département Informatique,"
                    + System.lineSeparator(),subFont));
            invite.add(new Chunk("Aux chargés d'enseignement en Informatique,"
                    + System.lineSeparator(),subFont));
            invite.add(new Chunk("Aux étudiants délégués",subFont));
            invite.setAlignment(Element.ALIGN_LEFT);
            invite.setIndentationLeft(200); 
            addEmptyLine(invite, 2);
            document.add(invite);

            Paragraph objet = new Paragraph();
            objet.add(new Chunk("Objet",Bold_Underline));  
            objet.add(new Chunk(" : Convocation au conseil de département Informatique " ,Small));
            objet.setAlignment(Element.ALIGN_LEFT);
            objet.setIndentationLeft(50); 
            document.add(objet);

            Paragraph corps = new Paragraph();
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Mesdames, Messieurs,"+ System.lineSeparator(),Small));
            corps.add(new Chunk("Vous êtes invité(e)s à participer à la réunion du ",Small));
            corps.add(new Chunk("Conseil de Département Informatique ",smallBold));
            corps.add(new Chunk("le : ",Small));
            corps.setAlignment(Element.ALIGN_LEFT);
            corps.setIndentationLeft(75); 
            document.add(corps);

            Paragraph Reu = new Paragraph();
            Reu.add(new Chunk(date + ", " + horaire + System.lineSeparator(),smallBold));
            Reu.add(new Chunk(lieu,smallBold));
            Reu.setAlignment(Element.ALIGN_CENTER);
            document.add(Reu);

            corps = new Paragraph();
            corps.add(new Chunk("L'ordre du jour prévu est le suivant",Underline));
            corps.add(new Chunk(" : ",Small));
            corps.setAlignment(Element.ALIGN_LEFT);
            corps.setIndentationLeft(75); 
            document.add(corps);

            Paragraph OrdreDuJour = new Paragraph();
            OrdreDuJour.add(new Chunk(ordre,smallBold));
            OrdreDuJour.setAlignment(Element.ALIGN_CENTER);
            document.add(OrdreDuJour);

            corps = new Paragraph();
            corps.add(new Chunk("Je rapelle que les représentants des étudiants et les vacataires "
                    + "sont convoqués afin d'être leurs porte-parole.",Small));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Par ailleurs, je vous demande de me faire parvenir au plus tôt"
                    + " les questions que vous souhaiteriez voir "
                    + "aborder lors de cette réunion.",Small));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Bien Cordialement.",Small));
            corps.setAlignment(Element.ALIGN_LEFT);
            corps.setIndentationLeft(75); 
            document.add(corps);

            Paragraph Signature = new Paragraph();
            Signature.add(new Chunk("Nom Prénom"+ System.lineSeparator(),smallBold));
            Signature.add(new Chunk("Responsabilité ",smallBold));
            Signature.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(Signature, 5);
            document.add(Signature);

            Paragraph test = new Paragraph();
            test.add(new Chunk("IUT d'Aix Marseille, Site d'Arles",BFont));
            test.add(new Chunk(" - 2 Rue Raoul Follereau BP 90170 - "
                    + "13637 Arles Cedex - France "+ System.lineSeparator(),Foot));
            test.add(new Chunk("Tel : +33 (0)4 13 55 21 00 - "
                    + "Fax : +33 (0)4 13 55 21 01 - ",Foot));
            test.add(new Chunk("http://iut.univ-amu.fr/sites/arles",FootBold));
            test.setAlignment(Element.ALIGN_CENTER);
            document.add(test);
            document.close();
        } 
        catch (DocumentException | IOException e){
        }
    }

    protected static void CompteRendu(String nom_reu,String CompteRendu,String Date,String Heure, ArrayList<Personnes> ListeInvite) 
            throws DocumentException, IOException {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(Main.PathApp+ 
                    "\\Pdf\\CompteRendu_"+nom_reu+".pdf"));
            document.open();
            document.addTitle("Compte-Rendu");
            document.addAuthor(Utilisateur.getPrenom()+ " "+Utilisateur.getNom());
            Paragraph preface = new Paragraph();
            Image img = Image.getInstance(Main.PathApp+"\\Logo_IUT.png");
            preface.add(new Image(img) {});
            preface.add(new Paragraph("Département Informatique, site d'Arles", YFont));
            addEmptyLine(preface, 1);
            document.add(preface);

            PdfPTable table = new PdfPTable(1);
            PdfPCell titre = new PdfPCell(new Phrase("Réunion : " + nom_reu));
            titre.setPadding(15);
            titre.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(titre);
            document.add(table);

            Paragraph tete = new Paragraph();
            addEmptyLine(tete, 1);
            tete.add(new Chunk("Séance ouverte à " + Heure +System.lineSeparator(),Small));
            tete.add(new Chunk("Présents : ",Small));
            System.out.println(ListeInvite.size());
            if (ListeInvite.size() == 1)
                tete.add(new Chunk(ListeInvite.get(0).getNom() + " " + ListeInvite.get(0).getPrenom(),Small));
            else if(ListeInvite.size()>1){
                for(int i = 0;i< ListeInvite.size(); i++){
                    tete.add(new Chunk(ListeInvite.get(i).getNom() + " " + ListeInvite.get(i).getPrenom() + ", ",Small));
                }
            }
            tete.setAlignment(Element.ALIGN_LEFT);
            tete.setIndentationLeft(50); 
            document.add(tete);

            Paragraph corps = new Paragraph();
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Sujet"+ System.lineSeparator(),smallBold));
            corps.add(new Chunk(CompteRendu,Small));
            corps.setAlignment(Element.ALIGN_LEFT);
            corps.setIndentationLeft(50); 
            document.add(corps);

            /*Paragraph foot = new Paragraph();
            foot.add(new Chunk("Séance levée à "+new Date()+System.lineSeparator(),Small));
            foot.setAlignment(Element.ALIGN_LEFT);
            foot.setIndentationLeft(50); 
            document.add(foot);*/
            document.close();
        } 
        catch (DocumentException | IOException e){
        }
    }
    
    public static void PageBon() throws DocumentException, IOException {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(Main.PathApp+
                    "\\Pdf\\BonPouvoir.pdf"));
            document.open();
            
            document.addTitle("Bon Pouvoir");
            document.addAuthor(Utilisateur.getPrenom()+ " "+Utilisateur.getNom());
            
            Paragraph preface = new Paragraph();
            Image img = Image.getInstance(Main.PathApp+"\\Logo_IUT.png");
            preface.add(new Image(img) {});
            preface.add(new Paragraph("Département Informatique, site d'Arles", YFont));
            addEmptyLine(preface, 5);
            document.add(preface);

            PdfPTable table = new PdfPTable(1);
            PdfPCell titre = new PdfPCell(new Phrase("Bon pour Pouvoir"));
            titre.setPadding(15);
            titre.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(titre);
            document.add(table);

            Paragraph corps = new Paragraph();
            addEmptyLine(corps, 3);
            corps.add(new Chunk("Mesdames, Messieurs,"+ System.lineSeparator(),Bon));
            corps.add(new Chunk("Je soussigné(e) "
                    + "................................................................."
                    + " né(e) le ............................. et"+ System.lineSeparator(),Bon));
            corps.add(new Chunk("demeurant au "
                    + "................................................................."
                    + "................................................."+ System.lineSeparator(),Bon));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("donne, par la présente, pouvoir à : ",Bon));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("................................................................."
                    + "......................................................................."+ System.lineSeparator(),Bon));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Pour voter et signer pour moi et en mon nom, "
                    + "tout formulaire et document nécessaire. "+ System.lineSeparator()
                    + "Elle pourra également requérir pour moi, tout document nécéssaire.",Bon));
            addEmptyLine(corps, 1);
            corps.add(new Chunk("Fait à ........................... "
                    + "le ............................. "+ System.lineSeparator(),Bon));
            corps.setAlignment(Element.ALIGN_LEFT);
            corps.setIndentationLeft(55);
            addEmptyLine(corps, 4);
            document.add(corps);

            Paragraph Signer = new Paragraph();
            Signer.add(new Chunk("Signature",SignatureBon));
            Signer.setAlignment(Element.ALIGN_RIGHT);
            Signer.setIndentationRight(55);
            document.add(Signer);
            document.close();
        } 
        catch (DocumentException | IOException e) {
        }
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++){
            paragraph.add(new Paragraph(" "));
        }
    }
}
       