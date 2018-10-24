package com.fatec.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.view.View;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

/**
 * @author Sham
 */

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ima_imagem")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ima_id")
    @JsonView({View.imagemFull.class})
    private long id;

    @Column(name = "ima_nome", length = 50, nullable = false)
    @JsonView({View.UsuarioFull.class, View.ImagemSimples.class})
    private String nome;

    @Column(name = "ima_tamanho", length = 50, nullable = false)
    @JsonView({View.UsuarioFull.class, View.ImagemSimples.class})
    private String tamanho;

    @Column(name = "ima_tipo", length = 20, nullable = false)
    @JsonView({View.UsuarioFull.class, View.ImagemSimples.class})
    private String tipo;

    @Column(name = "ima_imagem")
    @JsonView({View.imagemFull.class})
    private byte[] imagemBlob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.imagemFull.class})
    //@XmlElement(name = "usuario")
    @JoinColumn(name = "ima_id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "ima_string")
    @JsonView({View.ImagemSimples.class})
    private String imagemBase64;

    public Imagem() {
        super();
    }

    public Imagem(String path) {
        super();
        extrairBlob(path);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImagemBlob() {
        return imagemBlob;
    }

    public void setImagemBlob(byte[] imagemBlob) {
        this.imagemBlob = imagemBlob;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void extrairBlob(String path) {
        try {
            File file = new File(path);
            BufferedImage img = ImageIO.read(file);
            this.setTamanho(img.getWidth() + "x" + img.getHeight());
            this.setTipo(file.getName().substring(file.getName().indexOf("."), file.getName().length()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, this.tipo, baos);
            imagemBlob = baos.toByteArray();
            this.setImagemBlob(imagemBlob);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String str = String.format("Objeto Imagem - ID: %d Nome: %s / Tipo: %s Tamanho: %s /  Usuario: %s", id, nome, tipo, tamanho, usuario.getNome());
        return str;
    }

    public String getImagemBase64() {
        /*
        if (this.imagemBase64 == null) {
            this.imagemBase64 = Base64.getEncoder().encodeToString(this.imagemBlob);
        }
        */
        return this.imagemBase64;

    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
	
	/*

	String path = "img/img.png";
	Imagem imagem = new Imagem(path);
	System.out.println("Base : "+new String(Base64.getEncoder().encodeToString(imagem.getImagemBlob())));
	*/

}
