// Omitted
import API from '../services/api';
import React from 'react';
import 'materialize-css';
import { Col,  Table} from 'react-materialize';

export default class Testaxion extends React.Component {
    state = {
        funcionarios: [],
        funcionariosck:[]
      }
    
      async componentDidMount() {
        API.get("funcionario/list/all")
          .then(res => {
            console.log(res);
            const funcionarios = res.data;
            this.setState({ funcionarios });
          });
          API.get("funcionario/list/ck4")
          .then(res => {
            console.log(res);
            const funcionariosck = res.data;
            this.setState({ funcionariosck });
          });
        
      }
      renderFuncTable(){
        return this.state.funcionarios.map((func, index) => {
          const { id, nomeCompleto ,cpf, email, dataNascimento, telefone} = func //destructuring
          return (
             <tr key={id}>
                <td>{nomeCompleto}</td>
                <td>{cpf}</td>
                <td>{email}</td>
                <td>{new Date(dataNascimento).toLocaleDateString()}</td>
                <td>{telefone}</td>
             </tr>
          )
       })
      }
      
      renderCkTable(){
        return this.state.funcionariosck.map((funck) => {
          const { id, nomeCompleto ,cpf, email, dataNascimento, telefone  } = funck //destructuring
          console.log(funck);
          return (
             <tr key={id}>
                <td>{nomeCompleto}</td>
                <td>{cpf}</td>
                <td>{email}</td>
                <td>{new Date(dataNascimento).toLocaleDateString()}</td>
                <td>{telefone}</td>
             </tr>
          )
       })
      }
      render() {
        return (
          <Col className="card-panel grey lighten-3 z-depth-1">
            <Col className="card-panel grey lighten-3 z-depth-1">
            <Table>
            <thead>
                <tr>
                  <th data-field="nomeCompleto">
                    Nome Completo
                  </th>
                  <th data-field="cpf">
                    CPF
                  </th>
                  <th data-field="email">
                    E-mail
                  </th>             
                  <th data-field="dataNascimento">
                    Data Nasc.
                  </th>         
                  <th data-field="telefone">
                    Telefone
                  </th>                
                </tr>
              </thead>
              <tbody>
                {this.renderFuncTable()}
              </tbody>
            </Table>
           </Col>
           <div class="divider"></div>
           <div class="section"><h5>Funcionarios com menos de 4 Marcações</h5></div>
             


           <Col className="card-panel grey lighten-3 z-depth-1">

           <Table>
            <thead>
                <tr>
                  <th data-field="nomeCompleto">
                    Nome Completo
                  </th>
                  <th data-field="cpf">
                    CPF
                  </th>
                  <th data-field="email">
                    E-mail
                  </th>             
                  <th data-field="dataNascimento">
                    Data Nasc.
                  </th>         
                  <th data-field="telefone">
                    Telefone
                  </th>                
                </tr>
              </thead>
              <tbody>
                {this.renderCkTable()}
              </tbody>
            </Table>
           </Col> 
          </Col>
        )
      }
    }