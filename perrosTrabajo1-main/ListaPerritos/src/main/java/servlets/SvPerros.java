package servlets;

import com.mycompany.listaperritos.Perros;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "SvPerros", urlPatterns = {"/SvPerros"})
@MultipartConfig
public class SvPerros extends HttpServlet {
    private ArrayList<Perros> inPerros = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();

        // Inicialización del servlet
        ServletContext servletContext = getServletContext();
        String dataPath = servletContext.getRealPath("/data/perros.ser");
        File archivo = new File(dataPath);

        // Verificar si existe un archivo de datos de perros
        if (archivo.exists()) {
            cargarPerrosDesdeArchivo();
        } else {
            inPerros = new ArrayList<Perros>(); // Si no existe, inicializar una lista vacía.
        }
    }

    private String getFileName(Part part) {
        if (part != null) {
            String contentHeader = part.getHeader("content-disposition");
            for (String content : contentHeader.split(";")) {
                if (content.trim().startsWith("filename")) {
                    return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                }
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener los datos del formulario
        String nombre = request.getParameter("nombre");
        String raza = request.getParameter("raza");
        String puntos = request.getParameter("puntos");
        String edad = request.getParameter("edad");
        int puntosInt = 0;
        int edadInt = 0;

        System.out.println(nombre);
        // Convertir puntos y edad a enteros si se proporcionan
        if (puntos != null && !puntos.isEmpty()) {
            puntosInt = Integer.parseInt(puntos);
        }

        if (edad != null && !edad.isEmpty()) {
            edadInt = Integer.parseInt(edad);
        }

        // Obtener la imagen del formulario
        Part fotoPart = request.getPart("foto");
        String fileName = fotoPart.getSubmittedFileName();
        if (fileName != null) {
            fileName = new File(fileName).getName(); // Obtener solo el nombre del archivo
        }

        // Ruta para guardar la imagen
        String uploadDirectory = getServletContext().getRealPath("imagenes");
        String filePath = uploadDirectory + File.separator + fileName;

        try (InputStream input =fotoPart.getInputStream();
                 OutputStream output = new FileOutputStream(filePath)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            System.out.println("Imagen guardada en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar el error en caso de que ocurra una excepción al guardar la imagen
        }

        // Crear un nuevo objeto Perros y agregarlo a la lista
        Perros perroNuevo = new Perros(nombre, raza, fileName, puntosInt, edadInt);
        inPerros.add(perroNuevo);

        // Guardar la lista actualizada en el archivo
        guardarPerrosEnArchivo();

        // Establecer atributo y redirigir a la página principal
        request.setAttribute("inPerros", inPerros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void cargarPerrosDesdeArchivo() {
        try {
            String dataPath = getServletContext().getRealPath("/data/perros.ser");
            FileInputStream fis = new FileInputStream(dataPath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Cargar la lista de perros desde el archivo
            inPerros = (ArrayList<Perros>) ois.readObject();
            ois.close();
            System.out.println("Datos de los perros cargados exitosamente desde: " + dataPath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos de los perros: " + e.getMessage());
        }
    }

    private void guardarPerrosEnArchivo() {
        try {
            String dataPath = getServletContext().getRealPath("/data");
            File dataFolder = new File(dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            String filePath = dataPath + File.separator + "perros.ser";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                // Guardar la lista de perros en el archivo
                oos.writeObject(inPerros);
                System.out.println("Datos de los perros guardados exitosamente en: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de los perros: " + e.getMessage());
        }
    }

    public String getServletInfo() {
        return "short description";
    }
}

