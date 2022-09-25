<template>
  <div>
    <guest-join @submit="onSubmit"/>
  </div>
</template>

<script>
import GuestJoin from "@/components/products/GuestJoin";
import {mapActions} from "vuex";

export default {
  name: "GuestJoinView",
  components: {
    GuestJoin
  },
  methods: {
    ...mapActions([
        'requestCreateGuestInformationToSpring'
    ]),
    async onSubmit (payload){
      await this.requestCreateGuestInformationToSpring(payload)
      await this.$router.push({
        name: 'GoodsSaleListView'
      })
    }
  }
}
</script>

<style scoped>

</style>