import React, { Component } from "react";
import { Link} from "react-router-dom";
import api from "../../services/api";
import Logo from "../../logo.svg";

import { Form, Container } from "./styles";

class SignUp extends Component {
  state = {
    nomeCompleto: "",
    email: "",
    cpf:"",
    senha: "",
    telefone: "",
    endereco: "",
    dataNascimento:"",
    error: ""
  };

  handleSignUp = async e => {
    e.preventDefault();
    const { nomeCompleto, email,cpf, senha, telefone, endereco, dataNascimento } = this.state;
    if (!nomeCompleto || !email || !senha || !cpf) {
      this.setState({ error: "Preencha todos os dados para se cadastrar" });
    } else {

      try {
        await api.post("/funcionario/cadastro", { nomeCompleto, cpf, email, senha,telefone,dataNascimento, endereco });
        this.props.history.push("/");
      } catch (err) {
        console.log(err);
        this.setState({ error: "Ocorreu um erro ao registrar sua conta. T.T" });
      }
    }
  };

  render() {
    return (
      <Container className="card-panel grey lighten-3 z-depth-1">
        <Form className="card-panel grey lighten-3 z-depth-1" onSubmit={this.handleSignUp}>
          <img src={Logo}  alt="Pulse" />
          {this.state.error && <p>{this.state.error}</p>}
          <input
            type="text"
            placeholder="Nome de usuário"
            onChange={e => this.setState({ nomeCompleto: e.target.value })}
          />
          <input
            type="text"
            placeholder="CPF"
            onChange={e => this.setState({ cpf: e.target.value })}
          />
          <input
            type="email"
            placeholder="Endereço de e-mail"
            onChange={e => this.setState({ email: e.target.value })}
          />
          <input
            type="password"
            placeholder="Senha"
            onChange={e => this.setState({ senha: e.target.value })}
          />
          <input
            type="text"
            placeholder="Telefone"
            onChange={e => this.setState({ telefone: e.target.value })}
          />
          <input
            type="text"
            placeholder="Endereço Completo"
            onChange={e => this.setState({ endereco: e.target.value })}
          />
          <input
            type="date"
            placeholder="Data de Nascimento"
            onChange={e => this.setState({ dataNascimento: e.target.value })}
          />
          <button type="submit">Cadastrar</button>
          <hr />
          <Link to="/">Fazer login</Link>
        </Form>
      </Container>
    );
  }
}

export default SignUp;