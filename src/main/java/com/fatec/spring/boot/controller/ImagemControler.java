package com.fatec.spring.boot.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.spring.boot.model.Imagem;
import com.fatec.spring.boot.model.Usuario;
import com.fatec.spring.boot.service.ImagemService;
import com.fatec.spring.boot.service.UsuarioService;
import com.fatec.spring.boot.view.View;

@RestController
@RequestMapping("/imagem")
public class ImagemControler {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ImagemService imagemService;

    @RequestMapping(value = "/getById/{id_nome}")
    @JsonView(View.ImagemSimples.class)
    @Transactional
    public ResponseEntity<Imagem> getImagemById(@PathVariable("id_nome") String id_nome) {

        Long id = Long.parseLong(id_nome);
        Imagem imagem = imagemService.lerImagemById(id).get();

        return new ResponseEntity<Imagem>(imagem, HttpStatus.OK);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @JsonView(View.ImagemSimples.class)
    @Transactional
    public ResponseEntity<Imagem> create(@RequestBody Imagem imagem, HttpServletRequest request,
                                         HttpServletResponse response) {

        try {
            imagem = imagemService.incluirImage(imagem);
            Optional<Imagem> img = imagemService.lerImagemById(imagem.getId());
            if (img.isPresent()) {
                return new ResponseEntity<Imagem>(img.get(), HttpStatus.CREATED);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Imagem>(imagem, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getByUsuario/{nome}")
    @JsonView(View.ImagemSimples.class)
    @Transactional
    public ResponseEntity<Collection<Imagem>> getImagemByUserName(@PathVariable("nome") String nome) {

        Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();
        Set<Imagem> imagens = imagemService.lerImagensByUsuario(usuario);

        return new ResponseEntity<Collection<Imagem>>(imagens, HttpStatus.OK);

    }

    @RequestMapping(value = "/getFullByUsuario/{nome}")
    @JsonView(View.imagemFull.class)
    @Transactional
    public ResponseEntity<Collection<Imagem>> getImagemFullByUserName(@PathVariable("nome") String nome) {

        Usuario usuario = usuarioService.lerUsuarioByNomeUsuario(nome).get();
        Set<Imagem> imagens = imagemService.lerImagensByUsuario(usuario);

        return new ResponseEntity<Collection<Imagem>>(imagens, HttpStatus.OK);

    }

    @RequestMapping(value = "/getByEmail/{email}")
    @JsonView(View.ImagemSimples.class)
    @Transactional
    public ResponseEntity<Collection<Imagem>> getImagemByUserEmail(@PathVariable("email") String email) {

        Set<Imagem> imagens = imagemService.lerImagensByUsuarioEmail(email);

        return new ResponseEntity<Collection<Imagem>>(imagens, HttpStatus.OK);

    }

    @RequestMapping(value = "/getFullByEmail/{email}")
    @JsonView(View.imagemFull.class)
    @Transactional
    public ResponseEntity<Collection<Imagem>> getImagemFullByEmail(@PathVariable("email") String email) {

        Set<Imagem> imagens = imagemService.lerImagensByUsuarioEmail(email);

        return new ResponseEntity<Collection<Imagem>>(imagens, HttpStatus.OK);

    }

}
