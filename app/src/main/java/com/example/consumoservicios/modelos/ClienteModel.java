package com.example.consumoservicios.modelos;

public class ClienteModel {

        private String cliente;
        private String companiaServicio;
        private String contacto;
        private String servicio;
        private String titulo;

        /**
         * No args constructor for use in serialization
         *
         */
        public ClienteModel() {
        }

        /**
         *
         * @param titulo
         * @param contacto
         * @param companiaServicio
         * @param servicio
         * @param cliente
         */
        public ClienteModel(String cliente, String companiaServicio, String contacto, String servicio, String titulo)
        {
            super();
            this.cliente = cliente;
            this.companiaServicio = companiaServicio;
            this.contacto = contacto;
            this.servicio = servicio;
            this.titulo = titulo;
        }

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getCompaIaServicio() {
            return companiaServicio;
        }

        public void setCompaIaServicio(String compaIaServicio) {
            this.companiaServicio = compaIaServicio;
        }

        public String getContacto() {
            return contacto;
        }

        public void setContacto(String contacto) {
            this.contacto = contacto;
        }

        public String getServicio() {
            return servicio;
        }

        public void setServicio(String servicio) {
            this.servicio = servicio;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
}
