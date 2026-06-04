# 🚀 Calculadora DevOps — CI/CD con GitHub Actions, JaCoCo y SonarCloud

Proyecto Java con Maven que implementa un flujo completo de **integración continua (CI/CD)** usando:

- ✅ **GitHub Actions** — automatización del pipeline
- ✅ **JaCoCo** — cobertura de código
- ✅ **SonarCloud** — análisis estático de calidad

---

## 📁 Estructura del Proyecto

```
proyecto-devops/
├── .github/
│   └── workflows/
│       └── ci.yml              # Pipeline de GitHub Actions
├── src/
│   ├── main/java/com/devops/calculadora/
│   │   └── Calculadora.java    # Clase principal
│   └── test/java/com/devops/calculadora/
│       └── CalculadoraTest.java # Pruebas unitarias
├── pom.xml                     # Configuración Maven + JaCoCo + SonarCloud
└── README.md
```

---

## ⚙️ Configuración Inicial (paso a paso)

### 1. Clonar y subir a tu repositorio GitHub

```bash
git clone <este-repo>
cd proyecto-devops
git remote set-url origin https://github.com/TU_USUARIO/TU_REPO.git
git push -u origin main
```

### 2. Configurar SonarCloud

1. Ve a [sonarcloud.io](https://sonarcloud.io) e inicia sesión con tu cuenta de GitHub.
2. Crea una nueva organización (o usa la existente).
3. Importa tu repositorio de GitHub.
4. SonarCloud te dará un **Project Key** y **Organization Key**.
5. Genera un **token** en: *My Account → Security → Generate Tokens*.

### 3. Agregar el secreto `SONAR_TOKEN` en GitHub

1. Ve a tu repositorio en GitHub.
2. Abre: **Settings → Secrets and variables → Actions**.
3. Clic en **New repository secret**.
4. Nombre: `SONAR_TOKEN` | Valor: el token generado en SonarCloud.

### 4. Actualizar las claves en los archivos

En **`pom.xml`**, reemplaza:
```xml
<sonar.organization>TU_ORG_EN_SONARCLOUD</sonar.organization>
```

En **`.github/workflows/ci.yml`**, reemplaza:
```yaml
-Dsonar.projectKey=TU_PROJECT_KEY
-Dsonar.organization=TU_ORG_EN_SONARCLOUD
```

---

## 🔄 Cómo funciona el Pipeline

```
Push / Pull Request
        │
        ▼
┌───────────────────┐
│  Checkout código  │
└────────┬──────────┘
         │
         ▼
┌───────────────────┐
│  Setup Java 17    │
└────────┬──────────┘
         │
         ▼
┌───────────────────┐
│  mvn compile      │
└────────┬──────────┘
         │
         ▼
┌───────────────────┐     ❌ Falla si los tests no pasan
│  mvn verify       │◄─── ❌ Falla si cobertura < 70%
│  (tests + JaCoCo) │
└────────┬──────────┘
         │
         ▼
┌───────────────────┐
│  SonarCloud       │  Análisis de calidad y seguridad
└───────────────────┘
```

---

## 🧪 Ejecutar en local

```bash
# Compilar
mvn clean compile

# Ejecutar pruebas + reporte JaCoCo
mvn verify

# Ver reporte JaCoCo (abrir en el navegador)
open target/site/jacoco/index.html

# Ejecutar análisis SonarCloud (requiere SONAR_TOKEN)
mvn sonar:sonar \
  -Dsonar.projectKey=TU_PROJECT_KEY \
  -Dsonar.organization=TU_ORG \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.token=TU_TOKEN
```

---

## 🎬 Demostración del Video (requisitos)

| # | Escena | Cómo lograrlo |
|---|--------|---------------|
| 1 | Pipeline ejecutándose automáticamente | Hacer `push` o abrir un PR |
| 2 | Reporte SonarCloud generado | Ver pestaña SonarCloud del proyecto |
| 3 | Pipeline **fallando** por tests rotos | Romper un test (ver sección abajo) |
| 4 | Pipeline **corregido** | Restaurar el test y hacer push |

### ¿Cómo romper un test para el video?

Edita `CalculadoraTest.java` y cambia un valor esperado:

```java
// ANTES (correcto)
assertEquals(8.0, calculadora.sumar(3, 5), 0.001);

// DESPUÉS (roto — hará fallar el pipeline)
assertEquals(99.0, calculadora.sumar(3, 5), 0.001);
```

Haz commit y push → el pipeline fallará. Luego reviértelo → el pipeline pasará. ✅

---

## 📊 Cobertura de Código

JaCoCo está configurado para **fallar el build si la cobertura de líneas es menor al 70%**.

El reporte se genera en: `target/site/jacoco/index.html`

---

## 👥 Integrantes del Equipo

| Nombre | GitHub |
|--------|--------|
| Integrante 1 | @usuario1 |
| Integrante 2 | @usuario2 |
| Integrante 3 | @usuario3 |

---

## 🔗 Enlaces

- 📦 Repositorio: `https://github.com/TU_USUARIO/TU_REPO`
- 🎥 Video YouTube: `https://youtu.be/TU_VIDEO`
- ☁️ SonarCloud: `https://sonarcloud.io/project/overview?id=TU_PROJECT_KEY`
