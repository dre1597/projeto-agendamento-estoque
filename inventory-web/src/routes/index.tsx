import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/')({
  component: Home,
})

function Home() {
  return (
    <main className="flex min-h-svh flex-col items-center justify-center gap-2">
      <h1 className="text-3xl font-bold">inventory</h1>
      <p className="text-gray-500">TanStack Router + Tailwind rodando.</p>
    </main>
  )
}
