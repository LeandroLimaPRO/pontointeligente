import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import 'materialize-css';
import Logo from "../../logo.svg";
import api from "../../services/api";
import { login } from "../../services/auth";

import { Form, Container } from "./styles";

class SignIn extends Component {
  state = {
    email: "",
    senha: "",
    error: ""
  };

  handleSignIn = async e => {
    e.preventDefault();
    const { email, senha } = this.state;
    if (!email || !senha) {
      this.setState({ error: "Preencha e-mail e senha para continuar!" });
    } else {
      try {
        const response = await api.post("/funcionario/login?email=" + email + "&senha=" + senha);
        console.log(response);
        login(response.data);
        this.props.history.push({pathname: "/app/", state: {id: response.data.id}});

      } catch (err) {
        this.setState({
          error:
            "Houve um problema com o login, verifique suas credenciais."
        });
      }
    }
  };

  render() {
    return (
      <Container className="card-panel grey lighten-3 z-depth-1">
        <Form className="card-panel grey lighten-3 z-depth-1" onSubmit={this.handleSignIn}>
          <img src={Logo} alt="Pulse logo" />
          {this.state.error && <p>{this.state.error}</p>}
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
          <button type="submit">Entrar</button>
          <hr />
          <Link to="/signup">Cadastrar</Link>
        </Form>
      </Container>
    );
  }
}

export default withRouter(SignIn);