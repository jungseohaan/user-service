import useSWR from 'swr'
import axios from 'axios'
import { AUTH_USER_ID } from '@constants/env'
import { loginSerivce } from '@service'

export default function useUser() {
  const { data, error, mutate } = useSWR(
    `/api/v1/users`,
    async (url: string) => {
      let userId = axios.defaults.headers.common[AUTH_USER_ID]
      if (!userId) {
        await loginSerivce.silentRefresh()
      }
      userId = axios.defaults.headers.common[AUTH_USER_ID]
      if (userId) {
        return axios.get(`${url}/${userId}`).then(res => res.data)
      } else {
        throw new Error('No User')
      }
    },
  )

  const loading = !data && !error
  const isLogin = !Boolean(error) && Boolean(data)
  const loggedOut =
    error && (error.response?.status === 401 || error.response?.status === 403)

  return {
    user: data,
    loading: loading,
    isLogin,
    error,
    mutate,
    loggedOut,
  }
}
