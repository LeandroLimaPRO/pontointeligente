
import React from 'react';

import API from '../services/api';
import 'materialize-css';
import {Row, Col, Button, Table, Icon, Blockquote} from 'react-materialize';
export default class Aplicativo extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
        idant: this.props.location.state.id,
        funcionario: [],
        pontos: [],
        error:""
      };
    this.handleMarcar = this.handleMarcar.bind(this);
  }
      async componentDidMount() {
        API.get("funcionario/id/" + this.state.idant)
          .then(res => {
            console.log(res);
            const funcionario = res.data;
            this.setState({ funcionario });
          })
          API.get("ponto/idfuncionario/" + this.state.idant)
          .then(res => {
            console.log(res);
            const pontos = res.data;
            this.setState({ pontos });
          })
      }

      handleMarcar = async e => {
        e.preventDefault();
        const idf = this.state.funcionario.id;
        if (!idf) {
          this.setState({ error: "Funcionario não encontrado!" });
        } else {
          try {
            const response = await API.post("ponto/registrar?idfunc=" + idf);
            console.log(response);
            this.props.history.push({pathname: "/app/", state: {id: idf}});
    
          } catch (err) {
            this.setState({
              error:
                "Não foi possivel marcar ponto!"
            });
          }
        }
      };
      renderTablePontos() {
        return this.state.pontos.map((ponto, index) => {
           const { id, dataPonto, dayOfSem, checkOne, checkTwo,checkThree, checkFour, horaExtra, saldoDia } = ponto //destructuring
           return (
              <tr key={id}>
                 <td>{new Date(dataPonto).toLocaleDateString()}</td>
                 <td>{dayOfSem}</td>
                 <td>{checkOne}</td>
                 <td>{checkTwo}</td>
                 <td>{checkThree}</td>
                 <td>{checkFour}</td>
                 <td>{horaExtra}</td>
                 <td>{saldoDia}</td>
              </tr>
           )
        })
     }
      render() {
        return (
        <div>
        <Col className="col s12">
            <Row class="card-panel grey lighten-5 z-depth-1 valign-wrapper">
                  <Col className="col s9"><h1>Olá {this.state.funcionario.nomeCompleto}</h1></Col>
                  <Col class="card-panel grey lighten-5 z-depth-1 valign-wrapper"></Col>
                  <Button className="purple" floating large node="button" waves="light" onClick={this.handleMarcar.bind(this)}>
                    <Icon right large>fingerprint</Icon></Button>
                    {this.state.error && <Blockquote>{this.state.error}</Blockquote>}
              </Row>
        </Col>
        <Col>
        <Row class= "card-panel grey lighten-4 z-depth-1">
          <Col className="col s3">6-columns (one-half)</Col>
          <Col className="card-panel grey lighten-3 z-depth-1">
            <Table>
            <thead>
                <tr>
                  <th data-field="dataPonto">
                    Data Ponto
                  </th>
                  <th data-field="dayOfSem">
                    Sem.
                  </th>
                  <th data-field="checkOne">
                    1º
                  </th>             
                  <th data-field="checkTwo">
                    2º
                  </th>         
                  <th data-field="checkThree">
                    3º
                  </th>                
                  <th data-field="checkFour">
                    4º
                  </th>
                  <th data-field="horaExtra">
                    Hora Extra
                  </th>
                  <th data-field="saldoDia">
                    Saldo
                  </th>
                </tr>
              </thead>
              <tbody>
                {this.renderTablePontos()}
              </tbody>
            </Table>
          </Col>
        </Row>
        </Col>
        </div>
        )
      }
    }