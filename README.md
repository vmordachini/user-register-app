# Aplicativo de Cadastro de Usuários com Room

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white) ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) ![Room](https://img.shields.io/badge/Room-DB-orange?style=for-the-badge&logo=android) ![MVVM](https://img.shields.io/badge/Arquitetura-MVVM-blue?style=for-the-badge)

Este é um projeto acadêmico desenvolvido como atividade para o SENAI, focado em demonstrar o aprendizado sobre **persistência de dados locais** no Android utilizando a biblioteca **Room**.

A aplicação consiste em um sistema de CRUD (Create, Read, Update, Delete) completo para o cadastro de usuários, implementado com uma arquitetura moderna (MVVM) e componentes nativos do Android.

---

## 🚀 Visão Geral das Funcionalidades

* **📝 Cadastro de Usuários:** Tela de formulário para inserir nome, e-mail e telefone de um novo usuário.
* **💾 Persistência com Room:** Todos os usuários cadastrados são salvos localmente em um banco de dados SQLite, gerenciado pela biblioteca Room.
* **📋 Listagem de Usuários:** Uma tela separada exibe todos os usuários salvos no banco de dados em uma lista (`RecyclerView`).
* **✏️ Edição de Usuários:** Ao clicar em um usuário na lista, o usuário é levado de volta à tela de cadastro com os dados pré-preenchidos, permitindo a atualização das informações.
* **🗑️ Exclusão de Usuários:** É possível remover um usuário do banco de dados através da lista.
* **🧭 Navegação:** Implementação de navegação entre as telas de cadastro (`MainActivity`) e listagem (`UserListActivity`) usando `Intent`.

---

## 🛠️ Arquitetura e Tecnologias Utilizadas

O projeto foi estruturado seguindo uma arquitetura próxima do **MVVM (Model-View-ViewModel)**.

* **Linguagem:** **Kotlin**.
* **Persistência de Dados:** **Room Persistence Library** (parte do Android Jetpack) para criar e gerenciar o banco de dados SQLite local.
* **Componentes de Arquitetura:**
    * **ViewModel:** Utilizado (`UserViewModel`) para manter a lógica de negócio e os dados da UI, sobrevivendo a mudanças de configuração.
    * **LiveData:** (Implicitamente usado pelo `getAll()`) para observar mudanças no banco de dados e atualizar a UI automaticamente.
* **Interface do Usuário (UI):**
    * **Android Views (XML):** Layouts construídos com `ConstraintLayout`.
    * **RecyclerView:** Para exibição eficiente da lista de usuários.
    * **Adapter:** `UserListAdapter` para conectar os dados do Room ao `RecyclerView`.
* **Build System:** **Gradle**.

---

## 🏃‍♀️ Como Rodar a Aplicação

1.  **Pré-requisitos:**
    * [Android Studio](https://developer.android.com/studio) instalado e configurado.
    * Um Emulador Android configurado ou um dispositivo físico com o modo de desenvolvedor ativado.

2.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/vmordachini/user-register-app.git](https://github.com/vmordachini/user-register-app.git)
    cd user-register-app
    ```

3.  **Abra o projeto no Android Studio:**
    * No Android Studio, selecione "Open" (Abrir).
    * Navegue até a pasta onde você clonou o repositório e selecione-a.
    * Aguarde o Gradle sincronizar e construir o projeto.

4.  **Execute a aplicação:**
    * Selecione um dispositivo (emulador ou físico) na barra de ferramentas.
    * Clique no botão "Run 'app'" (ícone de play verde) para compilar e instalar o aplicativo no dispositivo selecionado.
