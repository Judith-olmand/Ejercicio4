# 🗄️ Ejercicio4 [ConexionOracleMaven] — Inserción con PreparedStatement

Este proyecto Java gestionado con Maven establece una conexión con Oracle Database para realizar inserciones seguras en la tabla `empleado`. En esta versión, se implementa el uso de sentencias preparadas para mejorar la eficiencia y la seguridad del sistema.

## 📋 Descripción del Proyecto
El propósito de esta aplicación es profundizar en el uso de **JDBC** (Java Database Connectivity), específicamente en la interfaz `PreparedStatement`. A diferencia de un `Statement` convencional, el uso de sentencias preparadas permite:
* **Seguridad**: Prevención automática de ataques de Inyección SQL.
* **Rendimiento**: Pre-compilación de la consulta en el motor de la base de datos.
* **Limpieza**: Código más legible al separar la estructura de la consulta de los datos dinámicos.

## 🎯 Funcionalidades del Menú
Al ejecutarse, el programa sigue este flujo lógico:
* **Conexión**: Carga los drivers y establece el enlace con Oracle usando `db.properties`.
* **Preparación**: Define la plantilla SQL de inserción con marcadores de posición (`?`).
* **Mapeo**: Asigna los valores al empleado (ID: 10, Nombre: "Sergio", Salario: 2355.15).
* **Ejecución**: Impacta los cambios en la base de datos y confirma la operación.

## 🏗️ Estructura del Proyecto
```text
Ejercicio4 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Singleton de configuración
│       │       └── ☕ Main.java            # Lógica principal de inserción
│       └── 📁 resources/
│           └── 📄 db.properties           # Credenciales externas
│
├── 📁 target/                             # Generado por Maven
├── 🚫 .gitignore                          # Archivos omitidos (IDE y config)
└── 📄 pom.xml                             # Dependencias (OJDBC11)
```

## 📄 Formato del Archivo de Entrada
Para que el programa funcione, asegúrate de configurar tu archivo `src/main/resources/db.properties`:
```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=tu_usuario
db.password=tu_contraseña
```

## 🚀 Compilación y Ejecución

### Requisitos
* **Java JDK 17 o superior**.
* **Maven 3.8+**.
* **Oracle Database** (XE o Enterprise) activo.

### Instrucciones
1. Abre una terminal en la raíz del proyecto.
2. Compila el código:
   ```bash
   mvn clean compile
   ```
3. Ejecuta la aplicación:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   
```

## 🔧 Características Técnicas Implementadas
* **Sentencias Parametrizadas**: Uso de `ps.setInt`, `ps.setString` y `ps.setDouble`.
* **Gestión de Recursos**: Uso de bloque `try-with-resources` para evitar fugas de memoria.
* **Configuración Externalizada**: Separación total entre la lógica de negocio y las credenciales de acceso.
* **Manejo de SQL**: Captura y reporte de errores mediante `SQLException`.

## 🎮 Ejemplo de Uso Visual

**Datos insertados:**
* **ID**: 10
* **Nombre**: "Sergio"
* **Salario**: 2355.15

**Salida en Consola:**
```bash
Conexión establecida con Oracle.
Empleado añadido con éxito
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 4 - Dominando JDBC y PreparedStatement*