<img width="845" height="377" alt="image" src="https://github.com/user-attachments/assets/159916fc-1ce2-4cab-9483-6af6c57c946f" />


# CRUD de Gestión de Funcionarios - Desarrollo de software seguro - IU Digital Antioquia

Este proyecto es una aplicación de escritorio desarrollada en **Java Swing** para la gestión de funcionarios. Implementa una arquitectura por capas utilizando el patrón de diseño **DAO (Data Access Object)** para garantizar un código limpio, mantenible y escalable.

## 🚀 Características
* **CRUD Completo:** Registro, consulta, actualización y eliminación de funcionarios.
* **Validación de Datos:** Control de errores para formatos de fecha (AAAA-MM-DD), campos obligatorios y tipos de datos numéricos.
* **Interfaz Intuitiva:** Tabla interactiva que carga los datos en el formulario al hacer clic.
* **Arquitectura Profesional:** Separación clara entre la interfaz gráfica, la lógica de negocio y el acceso a datos.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java (JDK 17+)
* **IDE:** NetBeans
* **Base de Datos:** MySQL
* **Librerías:** JDBC MySQL Connector (incluido en la carpeta `/lib`)

## 📋 Requisitos Previos
Antes de ejecutar la aplicación, asegúrate de tener instalado:
1. **Java Development Kit (JDK) 17** o superior.
2. **MySQL Server** y un gestor como MySQL Workbench o phpMyAdmin.

## 🔧 Configuración e Instalación

### 1. Base de Datos
Debes crear la estructura de la base de datos antes de correr el programa:
1. Crea una base de datos llamada `actividad_1`.
2. Importa el script de creación: `sql/creacion_base_datos.sql`.
3. (Opcional) Importa los datos de prueba: `sql/poblado_tablas.sql`.

### 2. Conexión en Java
Dirígete a la clase `DbConnection.java` y ajusta los siguientes parámetros según tu configuración local de MySQL:

```java
private static String url = "jdbc:mysql://localhost:3306/actividad_1";
private static String user = "tu_usuario";
private static String pass = "tu_password";
```

### 3. Librerías
El conector mysql-connector-j-9.7.0.jar ya se encuentra en la carpeta /lib del proyecto. Asegúrate de que esté agregado al Classpath de tu IDE.

## 📂 Estructura del Proyecto


```
IU_1/
├── src/                # Código fuente (.java)
│   ├── clases/         # Entidades (Funcionario)
│   ├── formularios/    # Interfaces gráficas (VistaFuncionarios)
│   ├── interfaces/     # Definición y lógica del DAO
│   └── service/        # Conexión a la base de datos
├── lib/                # Librerías externas (.jar)
├── sql/                # Scripts de la base de datos (.sql)
└── README.md           # Documentación del proyecto
```
## 👤 Autor
Santiago Monsalve Zapata - Tecnologia en desarrollo de software - IU Digital de Antioquia
