package com.example.appweb.model.Data.DAO;

import com.example.appweb.model.Usuario;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class UsuarioDAO {
    public static void agregarUsuario(DSLContext query, Usuario usuario){
        Table tablaCategoria = table(name("Usuario"));
        Field[] columnas = tablaCategoria.fields("rut", "nombre", "edad");
        query.insertInto(tablaCategoria, columnas[0], columnas[1], columnas[2])
                .values(usuario.getRut(), usuario.getNombre(), usuario.getEdad())
                .execute();
    }
    public static List obtenerUsuario(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaUsuarios(resultados);
    }
    private static List obtenerListaUsuarios(Result resultados){
        List<Usuario> usuarios = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String rut = (String) resultados.getValue(fila, "rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            int edad = (Integer) resultados.getValue(fila, "edad");

            usuarios.add(new Usuario(nombre, edad, rut));
        }
        return usuarios;
    }
}
