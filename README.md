# app-orgs-alura

App **Orgs** — cadastro e listagem de produtos, desenvolvido no curso de fundamentos Android da Alura.

## Objetivo

Primeiro app "completo" do curso: formulário de cadastro (`FormularioProdutoActivity`) alimentando uma lista (`ListaProdutosActivity`), com DAO em memória.

## Tecnologias

- Kotlin
- RecyclerView, AppCompat, Material, ConstraintLayout
- AGP 4.2.1 / Gradle 6.7.1

## Pré-requisitos

- **JDK 11** (Gradle 6.x não roda em JDK 8 nem 17+)
- Android SDK com Platform recente

## Como rodar

```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties   # macOS
./gradlew assembleDebug
```

Ou abrir no Android Studio e executar no emulador/dispositivo.
