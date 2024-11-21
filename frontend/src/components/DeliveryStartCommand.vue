<template>
    <v-card outlined>
        <v-card-title>
            DeliveryStart
        </v-card-title>

        <v-card-text>
            <String label="Orderid" v-model="value.orderid" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deliveryStart"
            >
                DeliveryStart
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeliveryStartCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderid = '';
        },
        watch: {
        },
        methods: {
            deliveryStart() {
                this.$emit('deliveryStart', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

