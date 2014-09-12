package com.nicetech.optimus.model.dao;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.net.URLDecoder.decode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;

public class Source {

    private String relativePath;
    private final XStream XSTREAM;
    private final String filename;

    /**
     * PROTECTED O MODIFICADOR PROTECTED DEIXARÁ VISÍVEL O ATRIBUTO PARA TODAS
     * AS OUTRAS CLASSES E SUBCLASSES QUE PERTENCEM AO MESMO PACOTE. A PRINCIPAL
     * DIFERENÇA É QUE APENAS AS CLASSES DO MESMO PACOTE TEM ACESSO AO MEMBRO. O
     * PACOTE DA SUBCLASSE NÃO TEM ACESSO AO MEMBRO.
     *
     * @param filename
     */
    public Source(String filename) {
        this.XSTREAM = new XStream();

        String path = Source.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            relativePath = decode(path, "UTF-8");
            int lastSlash = relativePath.lastIndexOf('/');
            relativePath = relativePath.substring(0, lastSlash + 1);

        } catch (UnsupportedEncodingException ex) {
            showMessageDialog(null, ex.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.filename = relativePath + filename;
    }

    /**
     * O MÉTODO ABAIXO LER O ARQUIVO.
     *
     * @param filename CAMINHO RELATIVO DO ARQUIVO XML.
     * @return
     */
    private File readXml() {
        File file = new File(this.filename);
        if (!file.isFile()) {
            try {
                FileWriter fw = new FileWriter(this.filename);
                try (BufferedWriter w = new BufferedWriter(fw)) {
                    w.write("<list></list>");
                }
                file = new File(this.filename);
                return file;

            } catch (IOException ex) {
                getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return file;
    }

    public Object getDados() {
        return this.XSTREAM.fromXML(this.readXml());
    }

    /**
     * O MÉTODO ABAIXO ESCREVE NO ARQUIVO.
     *
     * @param dados
     */
    protected void escreverXml(List<?> dados) {
        try {
            try (FileWriter fw = new FileWriter(this.filename);
                    BufferedWriter w = new BufferedWriter(fw)) {
                w.write(this.XSTREAM.toXML(dados));
            }
        } catch (IOException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private static final Logger LOG = getLogger(Source.class.getName());
}
